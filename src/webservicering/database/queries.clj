(ns webservicering.database.queries
  (:require [webservicering.database.database-config :refer [database-config
                                                             sql-insert-account
                                                             sql-search-account-by-id
                                                             sql-update-account-owner
                                                             sql-delete-account-by-id]]))

(defn insert-account [account]
  (sql-insert-account database-config account))

(defn search-account-by-id [id]
  (sql-search-account-by-id database-config id))

(defn update-account-owner [account]
  (sql-update-account-owner database-config account))

(defn delete-account-by-id [account]
  (sql-delete-account-by-id database-config account))