(defproject ownerfinder "0.1.0-SNAPSHOT"
  :description "Simple command line tool to generate a Set of owner/group values of all subdirs and files given a root directory"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/data.csv "0.1.3"]]
  :keep-non-project-classes true
  :profiles {:uberjar {:aot :all}}
  :auto-clean false
  :main ownerfinder.core)
