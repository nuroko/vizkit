(ns nuroko.vizkit.demo.app
  (:use [mikera.cljutils error])
  (:use [nuroko.vizkit core])
  (:use clojure.core.matrix)
  (:require [mikera.image [core :as img]])
  (:import [javax.swing UIManager JFrame SwingUtilities JButton JPanel])
  (:import [java.awt Font])
  (:import [net.miginfocom.swing MigLayout])
  (:import [mikera.gui BackgroundPanel])) 

(set! *warn-on-reflection* true)
(set! *unchecked-math* true)
(set-current-implementation :vectorz)

(def ^Font font (Font. "Arial" Font/BOLD 20))

(def city-image (img/load-image "nuroko/image/city.jpg"))

(defn button ^JButton [^String text]
  (let [b (JButton. text)]
    (.setFont b font)
    b))

(defn nav-panel ^JPanel []
  (let [^MigLayout miglayout (MigLayout. "insets 20, gap 20, wrap 1, fillx" "[100%]" "")
        ^JPanel p (JPanel. miglayout)
        b1 (button "Hello World")
        b2 (button "Power Off!")]
    (.setOpaque p false)
    (.add p b1 "w 100%")
    (.add p b2 "w 100%")
    p))

(defn launch []
  (println "Launching....")
  
  (SwingUtilities/invokeLater 
    (fn []
      (UIManager/setLookAndFeel "org.pushingpixels.substance.api.skin.SubstanceTwilightLookAndFeel")
      (let [^JFrame frame (JFrame.)
            ^MigLayout miglayout (MigLayout. "insets 0" "[256px][768px]" "[768px]")
            ^BackgroundPanel p1 (BackgroundPanel. miglayout)
            
            ]
        (.setImage p1 city-image)
        (.add (.getContentPane frame) p1)
        (.add p1 (nav-panel) "w 100%")
        (.pack frame)
        (.setVisible frame true))))
  )