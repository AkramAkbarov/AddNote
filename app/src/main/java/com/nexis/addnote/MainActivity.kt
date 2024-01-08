 package com.nexis.addnote

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nexis.addnote.databinding.ActivityMainBinding

 class MainActivity : AppCompatActivity() {
     private lateinit var notesAdapter: NotesAdapter
     private lateinit var binding: ActivityMainBinding
    private lateinit var  db :NoteDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        db= NoteDatabaseHelper(this)
        notesAdapter = NotesAdapter(db.getAllNotes(),this)
        binding.notesRecyclerView.layoutManager=LinearLayoutManager(this)
        binding.notesRecyclerView.adapter=notesAdapter
        setContentView(binding.root)
        binding.addButton.setOnClickListener {
            val intent=Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
        }

    }
     override fun onResume() {
         super.onResume()
         notesAdapter.rafreshData(db.getAllNotes())
     }
}