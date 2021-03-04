package com.example.easylearn.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.easylearn.R
import com.example.easylearn.databinding.FragmentLoginFragmentBinding
import com.example.easylearn.presentation.LoginPresenter
import com.example.easylearn.presentation.LoginView
import com.example.easylearn.ui.movieList.MovieListFragment
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class LoginFragment : MvpAppCompatFragment(), LoginView {

    @InjectPresenter
    lateinit var presenter: LoginPresenter
    lateinit var binding: FragmentLoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login_fragment, container, false
        )

        binding.loginBtnSignIn.setOnClickListener {
            presenter.onSignButtonClicked(
                binding.loginLoginText.text.toString(),
                binding.loginPasswordText.text.toString()
            )
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setTitle("Auth")
    }

    override fun showMessageError() {
        activity.apply {
            Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
        }
    }

    override fun toMainScreen() {
        activity?.apply {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, MovieListFragment())
                .commit()
        }
//        val intent = Intent(this, MovieListActivity::class.java)
//        startActivity(intent)

    }
}
