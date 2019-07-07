package com.arindam.abode.ui.write

import android.os.Bundle
import com.arindam.abode.R
import com.arindam.abode.di.component.ActivityComponent
import com.arindam.abode.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_write.*

/**
 * Created by Arindam Karmakar on 2019-07-07.
 */

class WriteActivity : BaseActivity<WriteViewModel>() {

    override fun provideLayoutId() = R.layout.activity_write
    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {
        // Check for isEdit to set Header Text
        intent.extras?.let {

        }

        backButton.setOnClickListener { finish() }
        saveButton.setOnClickListener {
            val note = noteText.text.toString()
            viewModel.saveNote(note)
            finish()
        }
    }
}
