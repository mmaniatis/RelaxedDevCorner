(this.webpackJsonpapp=this.webpackJsonpapp||[]).push([[0],{19:function(e,t,n){},28:function(e,t){e.exports="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAABxklEQVRYR+1XPY9BQRQ9s4jERygkImqF3yAk/IanJEo2oaJ52S0EW9Po6IiCH6ERjVIiIUEiqxCfESTEbGYSK3aLN9t4W7zb3sk9555778xcAuBFkiSZEPIKwIXn2JxSWm42mx9EkqQ3QkjuObiPKJTSdxIOhz+fmPnPPOeMAFUj+xumRkBTQFNAU+BPChBC4HK5cDqdsFqtHu4vg8EAp9OJzWaD/X4vfLcJE/B4PEilUtDpdDCZTBgOhyiVShzM7/cjFovhcDjAbrej3W6jWq3ier0qEhEiYDabUSwWUalU0O12wbJNJBIYDAYYjUaQZRn5fB6TyQQ2mw3pdBq1Wo37lUyIgM/nQygUQi53fzRZOSiliEajuFwuqNfr31g3nxI48wsRCAQCXOZCofArJpOe9USj0RDB+3VGiIDVauUlKJfL6PV60Ov1vOb9fh/L5RKZTAbZbBaz2QwWiwXxeBytVgvj8ViRlBABFsXr9SKZTOJ8PnOQ6XTKm3C73SIYDCISiWC9XsPhcKDT6fB+YaVRMmECLBCbALfbjePxiMVi8RDbaDTyEWXjudvtlHDv/aJ9SDQFNAU0Bf6DAuquZqovp2qv518RpOOrnTHdLQAAAABJRU5ErkJggg=="},34:function(e,t,n){e.exports=n(50)},50:function(e,t,n){"use strict";n.r(t);var a=n(1),r=n.n(a),i=n(16),o=n.n(i),l=n(3),c=n(4),s=n(7),u=n(5),m=n(6),h=(n(19),n(17)),d=n(8),p=n(53),g=n(27),E=n(11),f=n(28),b=n.n(f),v=function(e){function t(e){var n;return Object(l.a)(this,t),(n=Object(s.a)(this,Object(u.a)(t).call(this,e))).state={isOpen:!1},n.toggle=n.toggle.bind(Object(h.a)(n)),n}return Object(m.a)(t,e),Object(c.a)(t,[{key:"toggle",value:function(){this.setState({isOpen:!this.state.isOpen})}},{key:"CheckAuthentication",value:function(){return"True"===(new E.a).get("IsAuthenticated")}},{key:"IsAdmin",value:function(){return"True"===(new E.a).get("IsAdmin")}},{key:"GetSignInButton",value:function(){if(!this.CheckAuthentication())return r.a.createElement(g.GoogleLogin,{clientId:"170017586676-2p1e2cpf0jgt8b1946crn20ipduli4g5.apps.googleusercontent.com",buttonText:"Login",onSuccess:function(e){return fetch("https://prd-app-relaxeddevcorner.azurewebsites.net/api/Account/Authenticate?idTokenString="+e.tokenId,{method:"GET",headers:{}}).then((function(e){return e.json()})).then((function(e){if(null!=e){var t=new E.a;null!=e.email&&(t.set("IsAuthenticated","True"),e.isAdmin&&t.set("IsAdmin","True"),null!=e.givenName?t.set("givenName",e.givenName):t.set("givenName",""))}window.location.reload(!0)})).catch((function(e){return console.log(e)}))},onFailure:function(e){(new E.a).set("IsAuthenticated","False")},cookiePolicy:"single_host_origin"});if(!0===this.CheckAuthentication()){var e=new E.a;return r.a.createElement(r.a.Fragment,null," ",r.a.createElement("div",{className:"UsernameBox"}," ",r.a.createElement("span",{id:"UserNameText"},"Welcome, ",r.a.createElement("br",null)," ",e.get("givenName")))," ")}}},{key:"ShowCreatePost",value:function(){if(this.CheckAuthentication()&&this.IsAdmin())return r.a.createElement(d.d,{href:"/CreatePost"},"Create Blog Post")}},{key:"render",value:function(){return r.a.createElement("div",{className:"NavBar"},r.a.createElement(d.e,{color:"dark",dark:!0,expand:"md",id:"MainNavBar"},r.a.createElement(d.f,{tag:p.a,to:"/"},r.a.createElement("img",{src:b.a,alt:"Logo"})," CodeCorner"),r.a.createElement(d.g,{onClick:this.toggle}),r.a.createElement(d.a,{isOpen:this.state.isOpen,navbar:!0},r.a.createElement(d.b,{className:"ml-auto",navbar:!0},r.a.createElement(d.c,null,this.ShowCreatePost()),r.a.createElement(d.c,null,r.a.createElement(d.d,{href:"/Algorithms"},"Algorithms & Puzzles")),r.a.createElement(d.c,null,r.a.createElement(d.d,{href:"https://twitter.com/michaelmaniatis"},"@mikedev")),r.a.createElement(d.c,null,r.a.createElement(d.d,{href:"https://github.com/mikejohnmaniatis"},"GitHub")),r.a.createElement(d.c,null,this.GetSignInButton())))))}}]),t}(a.Component),y=n(30),C=n.n(y),I=function(e){function t(e){var n;return Object(l.a)(this,t),(n=Object(s.a)(this,Object(u.a)(t).call(this,e))).handlePageClick=function(e){var t=e.selected,a=t*n.state.perPage;n.setState({currentPage:t,offset:a},(function(){n.receivedData()}))},n.viewPost=function(e,t){window.location.href="/ViewPost/"+e+"/"+t+"/"},n.state={posts:[],isLoading:!0,offset:0,perPage:5,currentPage:0,pageCount:null},n}return Object(m.a)(t,e),Object(c.a)(t,[{key:"receivedData",value:function(){var e=this;fetch("https://prd-app-relaxeddevcorner.azurewebsites.net/api/GetPosts",{method:"get",headers:{}}).then((function(e){return e.json()})).then((function(t){console.log(t.length);var n=t.slice(e.state.offset,e.state.offset+e.state.perPage).map((function(t,n){return r.a.createElement("div",{key:n,className:"PostCard",onClick:function(){return e.viewPost(t.category,t.slug)}},r.a.createElement("h3",{className:"PostCardText",id:"Title"},t.title),r.a.createElement("span",{className:"CardFooter"},"Written by: ",t.author," | ",t.cdDate," "),r.a.createElement("br",null))}));e.setState({pageCount:Math.ceil(t.length/e.state.perPage),postData:n,isLoading:!1})}))}},{key:"componentDidMount",value:function(){this.setState({isLoading:!0}),this.receivedData()}},{key:"render",value:function(){return this.state.isLoading?r.a.createElement("p",null,"Loading..."):r.a.createElement(r.a.Fragment,null,this.state.postData,r.a.createElement(C.a,{previousLabel:"prev",nextLabel:"next",breakLabel:"...",breakClassName:"break-me",pageCount:this.state.pageCount,marginPagesDisplayed:2,pageRangeDisplayed:5,onPageChange:this.handlePageClick,containerClassName:"pagination",subContainerClassName:"pages pagination",activeClassName:"active"}))}}]),t}(a.Component),j=function(e){function t(){return Object(l.a)(this,t),Object(s.a)(this,Object(u.a)(t).apply(this,arguments))}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement("div",{className:"HomeContainer"},r.a.createElement(v,null),r.a.createElement("div",{className:"PostContainer"},r.a.createElement(I,null)))}}]),t}(a.Component),S=function(e){function t(){var e;return Object(l.a)(this,t),(e=Object(s.a)(this,Object(u.a)(t).call(this))).state={},e}return Object(m.a)(t,e),Object(c.a)(t,[{key:"render",value:function(){return r.a.createElement(r.a.Fragment,null,r.a.createElement(v,null),r.a.createElement("div",{className:"jumbotron"},r.a.createElement("h1",null,"View & Practice Various Algorithmic Puzzles")),r.a.createElement("div",{className:"container"},r.a.createElement("div",{className:"row"},r.a.createElement("div",{className:"col-sm"},r.a.createElement("a",{href:"/ViewPuzzle/MaxDepthTree"},r.a.createElement("button",{className:"btn btn-primary btn-block"},"Max Depth Tree"))),r.a.createElement("div",{className:"col-sm"},r.a.createElement("a",{href:"/ViewPuzzle/TwoSum"},r.a.createElement("button",{className:"btn btn-primary btn-block"},"Two Sum"))))))}}]),t}(a.Component),k=function e(t){Object(l.a)(this,e),this.value=t,this.left=null,this.right=null},w=function(){function e(){var t=this;Object(l.a)(this,e),this.insert=function(e){var n=new k(e);null===t.root?t.root=n:t.insertTreeNode(t.root,n)},this.root=null}return Object(c.a)(e,[{key:"insertTreeNode",value:function(e,t){t.value<e.value?null===e.left?e.left=t:this.insertTreeNode(e.left,t):null===e.right?e.right=t:this.insertTreeNode(e.right,t)}},{key:"print",value:function(){document.getElementById("outputSection").textContent=JSON.stringify(this)}},{key:"reset",value:function(){this.root=null,document.getElementById("outputSection").textContent=""}}]),e}(),A=function(e){function t(){var e;return Object(l.a)(this,t),(e=Object(s.a)(this,Object(u.a)(t).call(this))).buildTreeNode=function(t){var n=document.getElementById("algoInput").value;""!==n&&(e.state.BST.insert(n),document.getElementById("algoInput").value="",e.state.BST.print())},e.getMaxDepth=function(){fetch("https://prd-app-relaxeddevcorner.azurewebsites.net/api/Algorithm/MaxDepthBinaryTree",{method:"post",body:JSON.stringify(e.state.BST),headers:{"Content-Type":"application/json"}}).then((function(e){return e.json()})).then((function(e){return document.getElementById("solution").textContent="Max Depth of the given binary tree is, "+e})).catch((function(e){return alert(e)}))},e.resetTree=function(){e.state.BST.reset()},e.state={BST:new w},e}return Object(m.a)(t,e),Object(c.a)(t,[{key:"componentDidMount",value:function(){document.getElementById("description").textContent="This algorithm takes in a Binary Search Tree as input, and returns the maximum depth in the given tree.",window.addEventListener("keypress",(function(e){13===e.keyCode&&""!==document.getElementById("algoInput").value&&document.getElementById("buildTree").click()}),!1)}},{key:"render",value:function(){return r.a.createElement(r.a.Fragment,null,r.a.createElement("div",{className:"AlgorithmSectionContainer"},r.a.createElement("div",{className:"inputSection"},r.a.createElement("input",{className:"CreateFormInput",name:"AlgorithmInput",type:"number",placeholder:"Type in a number to insert to tree and press enter or Insert Tree Node:",id:"algoInput"}),r.a.createElement("button",{id:"buildTree",onClick:this.buildTreeNode},"Insert Into Tree")),r.a.createElement("button",{onClick:this.getMaxDepth},"Submit"),r.a.createElement("button",{onClick:this.resetTree},"Reset"),r.a.createElement("p",{id:"outputSection"},"Tree Output ...")),r.a.createElement("div",{className:"CodeSectionContainer"},r.a.createElement("pre",null,r.a.createElement("code",{className:"UserCode"},"\n    public int MaxDepthBinaryTree(TreeNode root) {\n        return traverseAndReturnDepth(root);\n    }\n    \n   private static int traverseAndReturnDepth(TreeNode root){\n        if (root == null)\n            return 0;\n        int leftDepth = traverseAndReturnDepth(root.left);\n        int rightDepth = traverseAndReturnDepth(root.right);\n        return 1 + Math.max(leftDepth, rightDepth);\n    }\n}"))))}}]),t}(a.Component),N=function(e){function t(e){var n;return Object(l.a)(this,t),(n=Object(s.a)(this,Object(u.a)(t).call(this,e))).reset=function(){n.setState({inputArray:[],targetSum:0}),document.getElementById("outputSection").textContent="",document.getElementById("outputSection2").textContent=""},n.buildInputList=function(){var e=document.getElementById("algoInput").value;""!==e&&(document.getElementById("algoInput").value="",n.state.inputArray.push(parseInt(e)),document.getElementById("outputSection").textContent="["+n.state.inputArray+"]")},n.setTargetSum=function(){var e=document.getElementById("targetSum").value;""!==e&&(document.getElementById("targetSum").value="",n.setState({targetSum:parseInt(e)}),document.getElementById("outputSection2").textContent="Target sum: "+e)},n.getTwoSum=function(){var e=JSON.stringify({intArray:n.state.inputArray,target:n.state.targetSum});fetch("https://prd-app-relaxeddevcorner.azurewebsites.net/api/Algorithm/TwoSum",{method:"post",body:e,headers:{"Content-Type":"application/json"}}).then((function(e){return e.json()})).then((function(e){return document.getElementById("solution").textContent="The two indicies that sum to the target: ["+e+"]"})).catch((function(e){return alert(e)}))},n.state={inputArray:[],targetSum:0},n}return Object(m.a)(t,e),Object(c.a)(t,[{key:"componentDidMount",value:function(){document.getElementById("description").textContent="This algorithm takes in a list and a target, and it will find the indices of the two numbers that sum to the target.",window.addEventListener("keypress",(function(e){13===e.keyCode&&""!==document.getElementById("algoInput").value&&document.getElementById("ListInsert").click(),13===e.keyCode&&""!==document.getElementById("targetSum").value&&document.getElementById("TargetSumInsert").click()}),!1)}},{key:"render",value:function(){return r.a.createElement(r.a.Fragment,null,r.a.createElement("div",{className:"AlgorithmSectionContainer"},r.a.createElement("div",{className:"row"},r.a.createElement("div",{className:"col-sm"},r.a.createElement("div",{className:"inputSection"},r.a.createElement("input",{className:"CreateFormInput",name:"AlgorithmInput",type:"number",placeholder:"Insert list to be checked ...",id:"algoInput"})),r.a.createElement("button",{id:"ListInsert",onClick:this.buildInputList},"Insert Into list"),r.a.createElement("p",{id:"outputSection"},"List ...")),r.a.createElement("div",{className:"col-sm"},r.a.createElement("div",{className:"inputSection"},r.a.createElement("input",{className:"CreateFormInput",name:"AlgorithmInput",type:"number",placeholder:"Insert target sum ...",id:"targetSum"})),r.a.createElement("button",{id:"TargetSumInsert",onClick:this.setTargetSum},"Insert Target Sum"),r.a.createElement("p",{id:"outputSection2"},"Target sum:"))),r.a.createElement("button",{onClick:this.getTwoSum},"Submit"),r.a.createElement("button",{onClick:this.reset},"Reset")),r.a.createElement("div",{className:"CodeSectionContainer"},r.a.createElement("pre",null,r.a.createElement("code",{className:"UserCode"},"\n //returns two indices of numbers that sum to the target\n public int[] TwoSum(int[] intArray, Integer target)\n {\n     int[] sums = new int[2]; //list we will return\n\n     //hash table to track the pairings\n     HashMap<Integer, Integer> hash = new HashMap<>();\n\n     for (int i = 0; i < intArray.length; i++)\n     {\n         if (hash.containsKey(intArray[i])) //hash has pair\n         {\n             sums = new int[] {hash.get(intArray[i]), i}; //return the pair\n\n             return sums;\n         }\n         else //no pair has been found yet\n         {\n\n             hash.put(target - intArray[i], i); \n         }\n     }\n     \n     return sums; //return the pair if any\n }"))))}}]),t}(a.Component),O=function(e){function t(){var e;return Object(l.a)(this,t),(e=Object(s.a)(this,Object(u.a)(t).call(this))).state={algorithmName:""},e}return Object(m.a)(t,e),Object(c.a)(t,[{key:"componentDidMount",value:function(){this.props.match.params&&this.setState({algorithmName:this.props.match.params.algorithm})}},{key:"getAlgorithmComponent",value:function(){switch(this.state.algorithmName){case"MaxDepthTree":return r.a.createElement(A,null);case"TwoSum":return r.a.createElement(N,null)}}},{key:"render",value:function(){return r.a.createElement(r.a.Fragment,null,r.a.createElement(v,null),r.a.createElement("div",{className:"jumbotron"},r.a.createElement("h1",null,this.state.algorithmName),r.a.createElement("p",{id:"description"},"Code is written in Java."),r.a.createElement("p",{id:"solution"},"Solution will appear here ....")),r.a.createElement("div",{className:"AlgorithmPageContainer"},this.getAlgorithmComponent()))}}]),t}(a.Component),T=n(54),B=n(55),x=n(56),P=n(57),D=n(58),F=n(59),L=n(60),z=n(61),M=function(e){function t(e){var n;return Object(l.a)(this,t),(n=Object(s.a)(this,Object(u.a)(t).call(this,e))).state={post:[]},n}return Object(m.a)(t,e),Object(c.a)(t,[{key:"componentDidMount",value:function(){var e=this;if(this.props.match.params){var t=this.props.match.params.slug,n=this.props.match.params.category;fetch("https://prd-app-relaxeddevcorner.azurewebsites.net/api//GetPost?category="+n+"&slug="+t,{method:"GET",cache:"no-cache",headers:{"Content-Type":"application/json"},redirect:"follow",referrerPolicy:"no-referrer"}).then((function(e){return e.json()})).then((function(t){return e.setState({post:t})}))}}},{key:"render",value:function(){var e=this.state.post;return r.a.createElement("div",{className:"ViewPostContainer"},r.a.createElement("div",null,r.a.createElement(v,null)),r.a.createElement("div",{className:"shareButtons"},r.a.createElement(T.a,{url:window.location.href,title:"Check out this post on CodeCorner, "+e.title},r.a.createElement(B.a,{size:32,round:!0})),r.a.createElement(x.a,{url:window.location.href,title:e.title},r.a.createElement(P.a,{size:32,round:!0})),r.a.createElement(D.a,{url:window.location.href,title:e.title},r.a.createElement(F.a,{size:32,round:!0})),r.a.createElement(L.a,{url:window.location.href,title:e.title},r.a.createElement(z.a,{size:32,round:!0}))),r.a.createElement("div",{className:"jumbotron"},r.a.createElement("h1",null,e.title),r.a.createElement("p",null,"Written by: ",e.author)),r.a.createElement("div",{className:"article"},r.a.createElement("div",{className:"PostBody"},r.a.createElement("p",{id:"FormattedText",dangerouslySetInnerHTML:{__html:e.body}}))))}}]),t}(a.Component),R=n(31),J=function(e){function t(e){var n;return Object(l.a)(this,t),(n=Object(s.a)(this,Object(u.a)(t).call(this,e))).state={Category:"",Title:"",Slug:"",Body:""},n.handleChange=n.handleChange.bind(Object(h.a)(n)),n.createPost=n.createPost.bind(Object(h.a)(n)),n}return Object(m.a)(t,e),Object(c.a)(t,[{key:"handleChange",value:function(e){var t=e.target,n=t.value,a=t.name;this.setState(Object(R.a)({},a,n))}},{key:"createPost",value:function(e){var t=this.state.Category,n=this.state.Title,a=this.state.Slug,r=this.state.Body,i=new Date,o=JSON.stringify({category:t,title:n,slug:a,body:r,author:"Michael J. Maniatis",cdDate:i});fetch("https://prd-app-relaxeddevcorner.azurewebsites.net/api/CreatePost",{method:"post",body:o,headers:{"Content-Type":"application/json"}}).then((function(e){return e})).then((function(e){return window.location.reload(!0)})).catch((function(e){return alert(e)}))}},{key:"componentDidMount",value:function(){}},{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement(v,null),r.a.createElement("div",{className:"jumbotron"},r.a.createElement("h1",null,"Thanks for contributing!")),r.a.createElement("div",{className:"container"},r.a.createElement("div",{className:"CreatePostForm"},r.a.createElement("label",{className:"CreateFormLabel"},"Category:"),r.a.createElement("input",{className:"CreateFormInput",name:"Category",type:"text",value:this.state.Category,onChange:this.handleChange}),r.a.createElement("br",null),r.a.createElement("label",{className:"CreateFormLabel"},"Title:"),r.a.createElement("input",{className:"CreateFormInput",name:"Title",type:"text",value:this.state.Title,onChange:this.handleChange}),r.a.createElement("br",null),r.a.createElement("label",{className:"CreateFormLabel"},"Slug:"),r.a.createElement("input",{className:"CreateFormInput",name:"Slug",type:"text",value:this.state.Slug,onChange:this.handleChange}),r.a.createElement("br",null),r.a.createElement("label",{className:"CreateFormLabel"},"Body:"),r.a.createElement("textarea",{className:"CreateFormInput",id:"CreateFormBody",name:"Body",type:"textarea",value:this.state.Body,onChange:this.handleChange}),r.a.createElement("button",{onClick:this.createPost},"Submit"))))}}]),t}(a.Component),U=n(63),V=n(62),Q=n(64),W=function(e){function t(){var e;return Object(l.a)(this,t),(e=Object(s.a)(this,Object(u.a)(t).call(this))).state={},e}return Object(m.a)(t,e),Object(c.a)(t,[{key:"returnAdminRoutes",value:function(){var e=new E.a;if("True"==e.get("IsAdmin")&&"True"==e.get("IsAuthenticated"))return r.a.createElement(U.a,{path:"/CreatePost",exact:!0,component:J})}},{key:"render",value:function(){return r.a.createElement(V.a,null,r.a.createElement(Q.a,null,r.a.createElement(U.a,{path:"/",exact:!0,component:j}),r.a.createElement(U.a,{path:"/ViewPost/:category/:slug",exact:!0,component:M}),r.a.createElement(U.a,{path:"/Algorithms",exact:!0,component:S}),r.a.createElement(U.a,{path:"/ViewPuzzle/:algorithm",exact:!0,component:O}),this.returnAdminRoutes()))}}]),t}(a.Component);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));n(49);o.a.render(r.a.createElement(W,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}},[[34,1,2]]]);
//# sourceMappingURL=main.cf5824b1.chunk.js.map