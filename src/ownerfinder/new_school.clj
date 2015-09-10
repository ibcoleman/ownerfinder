(ns ownerfinder.new-school
  (require [clojure.data.csv :as csv]
           [clojure.pprint :as pprint]))


(def test-data
  "UNKNOWN|101|weblogic|101|/NAS/scholars/scholar/2010/A00017428/j-grails01158-pdf.pdf
UNKNOWN|3502|atd|102|/NAS/scholars/scholar/2010/A00017379/Thymeleaf_HTMLEscape.png
UNKNOWN|3502|atd|102|/NAS/scholars/scholar/2007/A00000152/MVN _ Generate Project.txt
UNKNOWN|3502|atd|102|/NAS/scholars/scholar/2007/A00000152/URLS_CQ5.txt
UNKNOWN|3502|atd|102|/NAS/scholars/scholar/2007/A00000152/MVN_Jboss_Deploy.PNG
gwh99|2541|atd|102|/NAS/scholars/scholar/2014/A00023334/102714 Venice Magunga DHRC.pdf
gwh99|2541|atd|102|/NAS/scholars/scholar/2014/A00023334/VENICE MAGUNGA RESUME.pdf")


(defn error [& args]
  (apply println args)
  :error)


(defn check-file
  "Check for the existence of the file; :error if it doesn't exist"
  [src-file]
  (.exists (clojure.java.io/as-file src-file)))

(defn reduce-owners
  []
  )


(defn collapse-owner-entries
  "Next we want to call a reduce function instead of doseq that takes the read-csv infile and returns a set of [ouid guid]"
  [lines]
  (reduce (fn [final-owner-set line]
            (do
              (def short-line (take 4 line))
              (conj final-owner-set (vec short-line))))
          #{}
          lines))


(defn process-to-set
  [src-file]
  (with-open [in-file (clojure.java.io/reader src-file)]
    (collapse-owner-entries (csv/read-csv in-file :separator \|))))


(defn print-results
  [result-set]
  (pprint/pprint result-set))

(defn write-results
  "Neatly write the contents from the result-set to the specified dest-file. For each thing in set, new line..."
  [result-set dest-file]
  (with-open [out-file (clojure.java.io/writer dest-file)]
    (csv/write-csv out-file (vec result-set)))
  )


(defn do-all-the-stuff
  [src-file dest-file]
  (println "Perms will be read from" src-file "and written to" dest-file)
  (if (check-file src-file)
    (let [final-owner-set (process-to-set src-file)]
      (print-results final-owner-set)
      (write-results final-owner-set dest-file))   
    (error "Source file" src-file "was not found!")))

