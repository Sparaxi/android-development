package com.example.googleapitest;

import org.json.JSONObject;

public class GbooksStringStorage {

    private String id;
    private String etag;
    private String selfLink;
    private JSONObject volumeInfo;

    public String getId() {
        return id;
    }

    public String getEtag() {
        return etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public JSONObject getVolumeInfo() {
        return volumeInfo;
    }

    @Override
    public String toString() {
        return "GbooksStringStorage{" +
                "id='" + id + '\'' +
                ", etag='" + etag + '\'' +
                ", selfLink='" + selfLink + '\'' +
                ", volumeInfo=" + volumeInfo +
                '}';


    }

    public GbooksStringStorage(String id, String etag, String selfLink, JSONObject volumeInfo) {
        this.id = id;
        this.etag = etag;
        this.selfLink = selfLink;
        this.volumeInfo = volumeInfo;
    }
}
//
//    "kind": "books#volume",
//            "id": "pf9SvgAACAAJ",
//            "etag": "DflWFBJiNtc",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/pf9SvgAACAAJ",
//            "volumeInfo":{
//            "title":"Meten en regelen via Android",
//            "subtitle":"met het Android I/O-board en Android Studio",
//            "authors":[
//            "Elbert Jan van Veldhuizen"
//            ],
//            "publishedDate":"2016-10-17",
//            "industryIdentifiers":[
//            {
//            "type":"ISBN_10",
//            "identifier":"9053812903"
//            },
//            {
//            "type":"ISBN_13",
//            "identifier":"9789053812907"
//            }
//            ],
//            "readingModes":{
//            "text":false,
//            "image":false
//            },
//            "printType":"BOOK",
//            "maturityRating":"NOT_MATURE",
//            "allowAnonLogging":false,
//            "contentVersion":"preview-1.0.0",
//            "panelizationSummary":{
//            "containsEpubBubbles":false,
//            "containsImageBubbles":false
//            },
//            "language":"nl",
//            "previewLink":"http://books.google.nl/books?id=pf9SvgAACAAJ&dq=android&hl=&cd=1&source=gbs_api",
//            "infoLink":"http://books.google.nl/books?id=pf9SvgAACAAJ&dq=android&hl=&source=gbs_api",
//            "canonicalVolumeLink":"https://books.google.com/books/about/Meten_en_regelen_via_Android.html?hl=&id=pf9SvgAACAAJ"
//
//            }
