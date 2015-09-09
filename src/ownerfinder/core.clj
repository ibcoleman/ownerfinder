(ns ownerfinder.core)



(defn only-files
  "Filter a sequence of files/directories by the .isFile property of java.io.File"
  [file-s]
  (filter #(.isFile %) file-s))


(defn only-dirs
  "Report on only directories"
  [file-s]
  (filter #(.isDirectory %) file-s))


(def ownership #{ ["ian" "atd"] ["root" "thing"] ["C00456" "wheel"]})

(defn get-owner-and-group
  [file]
  (let
      [path (.toPath file)
       link-options (into-array java.nio.file.LinkOption[java.nio.file.LinkOption/NOFOLLOW_LINKS])]  
    (println  (java.nio.file.Files/getPosixFilePermissions path link-options))
    (println (java.nio.file.Files/getOwner path link-options))))
    

(defn extract-file-ownership
  "Expects a set of files returns a Seq of vectors"
  [file-list]
  (doseq
      [f file-list]
    (get-owner-and-group f)))



(defn -main
  "Do the everything..."
  [root-directory]
  (let
      [tng-dir (file-seq (clojure.java.io/file root-directory))
       files (only-files tng-dir)
       dirs (only-dirs tng-dir)]
    (println "Your directory was" root-directory)
    (println "Found" (count files) "files.")
    (println "Found" (count dirs) "directories.")
    (println "Extracting ownership of files...")
    (extract-file-ownership files)
    (println "Extracting ownership of dirs...")
    (extract-file-ownership dirs)
    (println "Done...")))
