$(function(){
	//当前页码
	var currentPage = 0;
	//总页码
	var countPage = 0;
	//页面容量
	var psize = 4;
	//页面加载的时候首先调用一次（初始化）
	gopage(1,psize);
	function gopage(currentpage,pagesize){
		//获取总数据量
		var countTotal = $(".notice").length;
		//分页显示的数据量
		var pageSize = pagesize;
		//总页数
		//如果总量除以页面容量的余数大于1
		if(countTotal/pageSize > parseInt(countTotal/pageSize)){
			countPage = parseInt(countTotal/pageSize)+1; 
		}else{
			countPage = parseInt(countTotal/pageSize); 
		}
		//当前分页
		currentPage = currentpage;
		//开始显示的行
		var startRow = (currentpage-1)*pageSize+1;
	    //结束行
		var endRow = currentpage*pagesize;
		//如果结束行大于总记录数 则结束行为总记录数
		endRow = (endRow > countTotal) ? countTotal : endRow;  
		//遍历显示数据实现分页
		for(var i=1;i<(countTotal+1);i++){
			//循环获取某个控件
			var irow =$(".notice:eq("+(i-1)+")");
            //如果开始行之内并且不大于最后一行 就显示
			if(i>=startRow && i<=endRow){
				irow.show(500);
				//否则隐藏
			}else{
				irow.hide(500);
			}
		}
		//页码信息
		var tempStr = "<span style='float:left'>共"+countTotal+"条启示      共"+countPage+"页  当前第"+currentPage+"页</span>";
		//换页链接显示控制
		if(currentPage>1){
			tempStr += "<a id=\"firstpage\" href=\"javascript:void(0)\">首页</a>";
			tempStr += "<a id=\"prevpage\"  href=\"javascript:void(0)\" ><上一页</a>"
		}else{
			tempStr += "首页";
			tempStr += "<上一页";    
		}
		if(currentPage<countPage ){
			tempStr += "<a id=\"nextpage\" href=\"javascript:void(0)\">下一页></a>";
			tempStr += "<a id=\"lastpage\"  href=\"javascript:void(0)\">尾页</a>";
		}else{
			tempStr += "下一页>";
			tempStr += "尾页";    
		}
		//赋值给jsp
		$("#paging").html(tempStr);
		//启动换页功能
		pageJump();
	} 
	function pageJump(){
		$("#firstpage").click(function(){
			gopage(1,psize);
		});
		$("#prevpage").click( function(){
			gopage((currentPage-1),psize);
		});
		$("#nextpage").click(function(){
			gopage((currentPage+1),psize);
		});
		$("#lastpage").click(function(){
			gopage(countPage,psize);
		});
	}
	
});