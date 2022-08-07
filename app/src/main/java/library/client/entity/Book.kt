package library.client.entity

class Book(
    private var ID: Int,
    private var coverID: Int,
    private var title: String,
    private var author: String
) {
    public fun getID():Int{
        return this.ID
    }
    public fun getCoverID():Int{
        return this.coverID
    }
    public fun getTitle():String{
        return this.title
    }
    public fun getAuthor():String{
        return this.author
    }
}