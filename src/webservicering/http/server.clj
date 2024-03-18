(ns webservicering.http.server 
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.defaults :refer [api-defaults wrap-defaults]]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            [ring.middleware.params :refer [wrap-params]]
            [webservicering.http.routes :refer [app-routes]]))

(def app
  (-> app-routes
      (wrap-json-body {:keywords? true :bigdecimals? true})
      (wrap-json-response {:keywords? true :bigdecimals? true})
      (wrap-params {:encoding "UTF-8"})
      (wrap-defaults api-defaults)))

(defn run-server [port join?]
  (run-jetty app {:port port :join? join?}))
