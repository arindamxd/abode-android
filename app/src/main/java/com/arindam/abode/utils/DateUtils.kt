package com.arindam.abode.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Arindam Karmakar on 2019-07-08.
 */

internal fun getCurrentTimeStamp(): String = isoFromCalenderDateFormat(Calendar.getInstance())
internal fun isoFromCalenderDateFormat(calendar: Calendar): String {
    val date = calendar.time
    val formatted = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(date)
    return formatted.toString()
}