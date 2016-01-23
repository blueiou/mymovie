var myBookStores=angular.module("my.Books",[]);
myBookStores.service('Book',['$rootScope',function($rootScope) {
	var service={   //该函数中的一个变量
			//有一个数组books	
			books:[
	       {title:"一千零一夜",type:"儿童文学"},
	       {title:"java语言程序设计基础篇",type:"计算机编程"}
	       ], 	
		//有一个addbook方法
	       addBook:function(book){
	    	   service.books.push(book);
	    	   $rootScope.$broadcast('books.update');
	       }
	};
	return service;
}
]);

myBookStores.controller("book.list",['$scope','Book',function(scope,Book)
{
	scope.$on('books.update',function(event){

		scope.books=Book.books;
		scope.$apply();
		});
		scope.books=Book.books;
	
}]);


myBookStores.directive("addBookButton",['Book',function(Book){
	return{
		restrict:"A",
	link:function(scope,element,attrs){
		element.bind("click",function(){
	
		Book.addBook({title:"你若安好，便是晴天",type:"现代文学"});	
		});
	}
	};
}]);

