package com.example.juliadart.redditcodechallenge



class ApiManager(private val api : ApiClient = ApiClient()) {

//    fun getNews(): Observable<List<ChildData>> {
//        return Observable.create {
//                subscriber ->
//            val news = mutableListOf<ChildData>()
//            for (i in 1..10) {
//                news.add(ChildData(
//                    "Subreddit $i",
//                    "author $i",
//                    false, // clicked
//                    "Title $i",
//                    "subredditprefix $i",
//                    "http://reddit.com/pic",
//                    "http://reddit.com/news"
//
//                ))
//            }
//            subscriber.onNext(news)
//        }
//    }
}