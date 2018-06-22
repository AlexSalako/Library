"use strict";

(function () {

    function BooksDal (dal) {

        this.getBooks = function () {
            return dal.http.GET("rest/account/json");
        };

        this.saveBook = function (bookToSave) {
            return dal.http.POST("rest/account/json", bookToSave);
        };

        this.updateBook = function (bookToUpdate) {
            return dal.http.PUT("rest/account/json/", bookToUpdate);
        };

        this.deleteBook = function (bookToDelete) {
            return dal.http.DELETE("/rest/account/json/", bookToDelete);
        };
    }
    
    angular.module("bookApp").service("BooksDal", ["dal", BooksDal]);
}());