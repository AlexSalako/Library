"use strict";

(function() {

    var BookController =  function(BookService, $log) {
        
    	var vm = this;
        
        vm.isHidden = false;
        
        vm.hideTable = function()
        {
        	vm.isHidden = !vm.isHidden
        };
        
        function init() {
        	BookService.getBooks().then(function (results) {
           	vm.accounts = results;
           	$log.log("In the book controller the value of the result promise is ");
        	$log.log(JSON.stringify(vm.books));
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
       }
       
       init();
            
    };

    angular.module('bookApp').controller('bookController', ['BookService','$log', BookController]);
}());