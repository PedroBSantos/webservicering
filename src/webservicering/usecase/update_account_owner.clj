(ns webservicering.usecase.update-account-owner
  (:import [java.util UUID])
  (:require [schema.core :as s]))

(def AccountUpdate
  {:id UUID
   :owner String})

(s/defn ^:always-validate update-account-owner [input :- AccountUpdate update-account find-account]
  (let [account-id (:id input)
        account (find-account {:id account-id})]
    (if (nil? account)
      false
      (do
        (update-account input)
        true))))