package com.vladv.localbasestore.presentation.addfirestore

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.vladv.localbasestore.databinding.FragmentFireStoreBinding

import org.koin.androidx.viewmodel.ext.android.viewModel


class FireStoreFragment : Fragment() {
    private val viewModel by viewModel<FireStoreViewModel>()
    lateinit var binding: FragmentFireStoreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFireStoreBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FirebaseApp.initializeApp(requireContext())
        val db = Firebase.firestore

        binding.buttonAdd.setOnClickListener {
            viewModel.getUnit()
            viewModel.getProbe()
            viewModel.getRecord()
        }

        lifecycleScope.launchWhenCreated {
            viewModel.unitByFlow.collect {it->
                it.forEach {item->
                    val unitTable = hashMapOf(
                        "id" to item.id.toString(),
                        "unit" to item.unit
                    )

                    db.collection("unit")
                        .add(unitTable)
                        .addOnSuccessListener { documentReference ->
                            Log.d(
                                ContentValues.TAG,
                                "DocumentSnapshot added with ID: ${documentReference.id}"
                            )
                        }
                        .addOnFailureListener { e ->
                            Log.w(ContentValues.TAG, "Error adding document", e)
                        }
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.probeByFlow.collect { it ->
                it.forEach {item->
                    val unitTable = hashMapOf(
                        "id" to item.id.toString(),
                        "name" to item.name,
                        "alias" to item.alias
                    )

                    db.collection("probe")
                        .add(unitTable)
                        .addOnSuccessListener { documentReference ->
                            Log.d(
                                ContentValues.TAG,
                                "DocumentSnapshot added with ID: ${documentReference.id}"
                            )
                        }
                        .addOnFailureListener { e ->
                            Log.w(ContentValues.TAG, "Error adding document", e)
                        }
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.recordByFlow.collect {it->
                it.forEach {item->
                    val unitTable = hashMapOf(
                        "id" to item.id.toString(),
                        "timestamp" to item.timestamp.toString(),
                        "numberRecord" to item.numberRecord.toString(),
                        "value" to item.value.toString(),
                        "id_unit" to item.idUnit.toString(),
                        "id_probe" to item.idProbe.toString()
                    )

                    db.collection("record")
                        .add(unitTable)
                        .addOnSuccessListener { documentReference ->
                            Log.d(
                                ContentValues.TAG,
                                "DocumentSnapshot added with ID: ${documentReference.id}"
                            )
                        }
                        .addOnFailureListener { e ->
                            Log.w(ContentValues.TAG, "Error adding document", e)
                        }
                }
            }
        }

    }
}