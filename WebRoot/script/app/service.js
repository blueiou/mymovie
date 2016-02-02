var services = angular.module('mv.service', ['ngResource']);
services.factory('smv',function($resource)
		
{
	 var resource = $resource("smvlist.action?pageno=:pageno",
		      {
		        
		      },
		      {
		        // A custom method to update the picture of the person
		        updatePicture: {
		          method: "PUT",
		          isArray: false
		        }
		      }
		    );
/*	 resource.retrievePerson = function () {
		 return this.get(
			        {
			          //operation: "data.txt"
			        });
	    };*/
	 resource.retrievePerson = function (pageno) {
	      return this.get(
	        {
	          pageno: pageno
	        });
	    };
	    return resource;
}

);
services.factory('smvList', ['$resource', function ($resource) {
    return $resource('smvlist.action', {}, {
        query: {
            method: 'GET',
            params:{pageno:"1"},
            isArray: false,
            //url:'smvlist.action?'
        }
        
    });
}]);
services.factory('pmvList', ['$resource', function ($resource) {
    return $resource('pmvlist.action', {}, {
        query: {
            method: 'GET',
            params:{pageno:"1"},
            isArray: false,
            //url:'smvlist.action?'
        }
        
    });
}]);
services.factory('goodsList', ['$resource', function ($resource) {
    return $resource('allist.action', {}, {
        query: {
            method: 'GET',
            params:{pageno:"",m:"",id:""},
            isArray: false,
            //url:'smvlist.action?'
        }
        
    });
}]);

