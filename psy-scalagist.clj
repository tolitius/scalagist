(ns org.gitpod.scalagist
  (:require [clojure.string :as str]))

(defn slurpit [path-to-source]
  (let [source (try
      (slurp path-to-source)
      (catch Exception e (println e)))]
    source))

(defn gistify [source-scala]
  (str/replace source-scala #"\[[^\]]*\]+" ""))

(if-not (nth *command-line-args* 2 nil)
  (println "usage: psy-scalagist <path to source.scala>")
  (let [scala-source (slurpit (nth *command-line-args* 2))]
    (if scala-source
      (println (gistify scala-source)))))

