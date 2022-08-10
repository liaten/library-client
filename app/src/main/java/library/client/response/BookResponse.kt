package library.client.response

import library.client.entity.Book

interface BookResponse {
    fun returnBooks(output: ArrayList<Book?>?)
    fun returnBooks(output: ArrayList<Book?>?, table: String?)
    fun returnTable(active_table: String?)
}