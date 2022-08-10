package library.client.response

import library.client.entity.Event

interface EventResponse {
    fun returnEvents(output: ArrayList<Event?>?)
}