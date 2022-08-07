package library.client.response

import library.client.entity.Event
import java.util.ArrayList

interface EventResponse {
    fun returnEvents(output: ArrayList<Event?>?)
}