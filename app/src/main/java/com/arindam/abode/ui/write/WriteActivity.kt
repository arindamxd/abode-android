package com.arindam.abode.ui.write

import android.os.Bundle
import androidx.lifecycle.Observer
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
        viewModel.setNoteInfo(intent.extras)

        if (viewModel.isEdit()) {
            headerText?.text = this@WriteActivity.getString(R.string.note_edit)
            viewModel.getEditNoteText().observe(this, Observer { noteText.setText(it) })
        } else {
            headerText?.text = this@WriteActivity.getString(R.string.note_new)
        }

        backButton.setOnClickListener { finish() }
        saveButton.setOnClickListener {
            viewModel.saveNote(noteText.text.toString())
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        viewModel.getEditNoteText().removeObservers(this)
    }
}
