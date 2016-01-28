var services = angular.module('mv.service', ['ngResource']);
services.factory('smv',function($resource)
		
{
	 var resource = $resource("smvlist.action",
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
	 resource.retrievePerson = function () {
		 return this.get(
			        {
			          //operation: "data.txt"
			        });
	    };
	    return resource;
}

);

