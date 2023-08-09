package com.vladv.data.repository


import com.vladv.domain.model.ModelProbe
import com.vladv.domain.model.ModelRecord
import com.vladv.domain.model.ModelUnit
import com.vladv.domain.repository.RepositoryFirestore

class RepositoryFirestoreImpl():RepositoryFirestore {
    override suspend fun addRecord(record: List<ModelRecord>) {
        TODO("Not yet implemented")
    }

    override suspend fun addProbe(probe: List<ModelProbe>) {
        TODO("Not yet implemented")
    }

    override suspend fun addUnit(unit: List<ModelUnit>) {

//        val db = Firebase.firestore
//        unit.forEach{
//            val unitTable = hashMapOf(
//                "id" to it.id.toString(),
//                "unit" to it.unit.toString(),
//
//            )
//            db.collection("record")
//                .add(unitTable)
//                .addOnSuccessListener { documentReference ->
//                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//                }
//                .addOnFailureListener { e ->
//                    Log.w(TAG, "Error adding document", e)
//                }
//        }
    }
}