(ns nuroko.vizkit.core
  (:use [mikera.cljutils error])
  (:import [mikera.gui Frames JIcon])
  (:import [java.awt.image BufferedImage])
  (:import [javax.swing SwingUtilities JComponent JLabel JPanel]))

(defn label 
  "Creates a JLabel with the given content"
  (^JLabel [s]
    (let [^String s (str s)
          label (JLabel. s JLabel/CENTER)]
      (.setToolTipText label s)
      label)))

(defn component 
  "Creates a component as appropriate to visualise an object x" 
  (^JComponent [x]
    (cond 
      (instance? JComponent x) x
      (instance? BufferedImage x) (JIcon. ^BufferedImage x)
      :else (label (str x)))))

(defn show 
  "Shows a component in a new frame"
  ([com 
    & {:keys [^String title]
       :as options
       :or {title nil}}]
  (let [com (component com)]
    (Frames/display com (str title)))))

(defmacro invoke-later [& body]
  `(SwingUtilities/invokeLater (fn [] ~@body)))