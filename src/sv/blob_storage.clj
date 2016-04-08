(ns sv.blob-storage)

(defprotocol BlobStorage
  "A protocol for storing binary large objects. The protocol tries to
   foster implementations, which treat blobs as immutable data."
  (store
    [this ^java.io.InputStream in]
    "Stores the data from the InputStream in the BlobStorage and
     returns an UUID that must be used to retrieve the data again.")
  (retrieve
    [this ^java.util.UUID id]
    "Retrieves the data which is stored under the given UUID from the
     BlobStorage. Returns a java.io.InputStream with the data or nil, if
     a blob with the given UUID was not found.")
  (exists
    [this ^java.util.UUID id]
    "Returns true, if a blob with the given UUID exists in the
     BlobStorage.")
  (delete
    [this ^java.util.UUID id]
    "Deletes the data which is stored under the given UUID from the
     BlobStorage. Returns true, if the blob was found and deleted,
     otherwise false."))
