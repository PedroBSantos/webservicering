(ns webservicering.http.routes
  (:require [compojure.core :refer [defroutes DELETE GET PATCH POST]]
            [compojure.route :as route]
            [webservicering.http.handlers :refer [create-account-handler
                                                  delete-account-by-id-handler
                                                  find-account-by-id-handler
                                                  update-account-owner-handler]]))

(defroutes app-routes
  (POST "/accounts" [] create-account-handler)
  (GET "/accounts/:id" [] find-account-by-id-handler)
  (PATCH "/accounts" [] update-account-owner-handler)
  (DELETE "/accounts/:id" [] delete-account-by-id-handler)
  (route/not-found "Path Not Found"))
