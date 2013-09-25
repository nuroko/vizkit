(ns nuroko.vizkit.demo.app
  (:use [mikera.cljutils error])
  (:use [nuroko.vizkit core])
  (:import [javax.swing UIManager JFrame SwingUtilities JButton JPanel]))

(set! *warn-on-reflection* true)
(set! *unchecked-math* true)

(defn launch []
  (println "Launching....")
  
  (SwingUtilities/invokeLater 
    (fn []
      (UIManager/setLookAndFeel "org.pushingpixels.substance.api.skin.SubstanceTwilightLookAndFeel")
      (let [^JFrame frame (JFrame.)
            ^JPanel p1 (JPanel.)
            ^JButton b1 (JButton. "Hello World")
            ]
        (.add p1 b1)
        (.add (.getContentPane frame) p1)
        (.setVisible frame true))))
  )