(ns webservicering.usecase.find-account
  (:require [schema.core :as s])
  (:import [java.util UUID]))

(s/defn ^:always-validate find-account-by-id [account-id :- UUID find-account]
  (find-account {:id (str account-id)}))