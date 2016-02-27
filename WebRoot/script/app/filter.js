var filterApp=angular.module('mv.filter',['ngResource']);
filterApp.filter('order',function(){
	
	return function(input){
		var statue;
		if(!input){
			statue="无";
		}
		switch(input){
		case 0:
		statue="未付款";
		break;
		case 1:
			statue="已付款";
			break;
		default :statue="未付款";
		break;
		};
		return statue;
	}
	
});
filterApp.filter('time',function(){
	return function(input,type){
		var time;
		if(!input) time='ERROE';
		else if(type=='0'){
			time=input.substring(11,16);//只获取时、分
		}
		return time;
	};
});