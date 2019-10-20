"user strict";
var auth = auth || {}
auth =(()=>{
	let _, js,auth_vue_js
	let init =()=>{
		_ = $.ctx()
		js = $.js()
		auth_vue_js = js+'/vue/auth_vue.js'
	}
	let setContentView =()=>{
    	login()
    }
	let login =()=>{
		$('body').html(auth_vue.login_body)
		$('<button>',{
			text : 'Sign in',
			type : 'submit',
			click : e=>{
				e.preventDefault();
				let data = { uId : $('#uid').val(),
						uPw : $('#upw').val()
				}
				alert('로그인 전송아이디 : '+data.uId)
				$.ajax({
					url : _+'/user/login',
					type : 'POST',
					dataType : 'json',
					data : JSON.stringify(data),
					contentType : 'application/json',
					sucess : d =>{
						alert('ajax 로그인 성공아이디 : '+d.uId +'    '+
								'ajax 로그인 성공비번 : '+d.uPw)
					},
					error : e => {
						alert('로그인 ajax 실패')
					}
				})
			}
		})
		.addClass('btn btn-lg btn-primary btn-block')
		.appendTo('#a_login_button')
	}
	let join =()=>{
		alert('회원가입 클릭!!');
		$('body').html(auth_vue.join_body)
		$('<button>',{
			text : 'Continue to checkout',
			href : '#',
			type : 'submit',
			click : e=>{
				e.preventDefault();
				let data = { uId : $('#uid').val(),
						uPw : $('#upw').val()
				}
				alert('조인 전송아이디 :'+data.uId)
				$.ajax({
					url : _+'/user/join',
					type : 'POST',
					dataType : 'json',
					data : JSON.stringify(data),
					contentType : 'application/json',
					success : d => {
						alert('ajax 조인 성공아이디 : '+ d.uId +
								'ajax 조인 성공비번: ' + d.uPw)
						login()
					},
					error : e => {
						alert('조인 ajax 실패..!!!!!!!!!!')
					}
				})
			}
		})
		.addClass('btn btn-primary btn-lg btn-block')
		.appendTo('#a_join_button')
	}
	let onCreate =()=>{
		alert('온크리진입')
		init()
		$.getScript(auth_vue_js).done(()=>{
			alert('겟스크립트 진입')
			setContentView()
			$('#a_go_join').click(()=>{
				join()
			})	
		})

	}
	return {onCreate, login, join};
})();