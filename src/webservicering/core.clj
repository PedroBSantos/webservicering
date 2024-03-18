(ns webservicering.core
  (:require [webservicering.http.server :refer [run-server]])
  (:gen-class))

(defn -main
  [& _]
  (run-server 8080 false))
