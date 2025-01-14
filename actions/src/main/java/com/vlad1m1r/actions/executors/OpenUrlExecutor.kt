package com.vlad1m1r.actions.executors

import android.content.Intent
import android.net.Uri
import com.vlad1m1r.bltaxi.domain.Action

open class OpenUrlExecutor(): Executor {
    override fun canHandleAction(action: Action): Boolean {
        return action is Action.OpenUrlAction
    }

    override operator fun invoke(action: Action): Intent {
        val action = action as Action.OpenUrlAction
        var url = action.url
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://$url"
        }
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        return browserIntent
    }
}
