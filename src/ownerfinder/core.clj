(ns ownerfinder.core
  (require [ownerfinder.old-school :as os])
  (require [ownerfinder.new-school :as newschool]))




(defn -main
  "Do the everything..."
  [src-file dest-file]
  (newschool/do-all-the-stuff src-file dest-file))
