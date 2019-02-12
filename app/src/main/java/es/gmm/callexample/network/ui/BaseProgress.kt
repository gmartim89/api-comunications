package es.gmm.callexample.network.ui

import android.support.v4.widget.ContentLoadingProgressBar
import android.view.View
import android.view.View.VISIBLE

class BaseProgress() : IProgressBar {

    private lateinit var progress: View
    private var typeContentLoading: Boolean = false

    constructor(progress: View) : this() {
        typeContentLoading = false
        this.progress = progress
        hideProgress()
    }

    constructor(progress: ContentLoadingProgressBar) : this() {
        typeContentLoading = true
        this.progress = progress
        hideProgress()
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
        if (typeContentLoading) {
            (progress as ContentLoadingProgressBar).show()
        }
    }

    override fun hideProgress() {
        if (typeContentLoading) {
            (progress as ContentLoadingProgressBar).hide()
        } else {
            progress.visibility = View.GONE
        }
    }

}