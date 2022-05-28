package net.rzarroca.aboutMe

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import net.rzarroca.aboutMe.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nicknameButton.setOnClickListener {
            addNickName(it)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addNickName(view: View) {
        val nickname = binding.aboutNickname
        val nicknameTextView = binding.nicknameTextView

        nicknameTextView.text = "Hi" + nickname.text + "."
        nickname.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        closeKeyboard(view)
    }

    private fun closeKeyboard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}