(ns webservicering.http.handlers
  (:require [webservicering.database.queries :as q]
            [webservicering.usecase.create-account :refer [create-account]]
            [webservicering.usecase.delete-account :refer [delete-account-by-id]]
            [webservicering.usecase.find-account :refer [find-account-by-id]]
            [webservicering.usecase.update-account-owner :refer [update-account-owner]])
  (:import [java.util UUID]))

(defn create-account-handler
  [request]
  (let [request-body (:body request)
        account-created (create-account request-body q/insert-account)]
    {:status 200
     :body account-created}))

(defn find-account-by-id-handler [request]
  (let [account-id (UUID/fromString (get-in request [:params :id]))
        account (find-account-by-id account-id q/search-account-by-id)]
    (if (nil? account)
      {:status 404}
      {:status 200
       :body account})))

(defn update-account-owner-handler [request]
  (let [request-body (:body request)
        updated (update-account-owner request-body q/update-account-owner q/search-account-by-id)]
    (if (true? updated)
      {:status 204}
      {:status 404})))

(defn delete-account-by-id-handler [request]
  (let [account-id (get-in request [:params :id])
        deleted (delete-account-by-id account-id q/search-account-by-id q/delete-account-by-id)]
    (if (true? deleted)
      {:status 204}
      {:status 404})))
