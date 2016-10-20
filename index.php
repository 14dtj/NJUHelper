<?php
require 'vendor/autoload.php';
$app = new Slim\App();

/*
 * 用户登录
 */
$app->get('/login/{name}/{pwd}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
	$name = $request->getAttribute('name');
    $pwd = $request->getAttribute('pwd');
	$result = mysqli_query($conn,"SELECT * FROM user
    WHERE username='{$name}' and password='{$pwd}'");
	if(mysqli_num_rows($result)){
		$results = array();
		while ($row = mysqli_fetch_assoc($result)) {
			$results[] = $row;
		}
               
	       $response->write(json_encode($results[0])); 
  	 
    }else{
		$response->write("0");  
    }
	mysqli_close($conn);
    return $response;
});
/*
 * 用户注册
 */
 $app->post('/register', function ($request, $response,$args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $user = $request->getParsedBody();
    $result = mysqli_query($conn,"INSERT INTO user(username,password,gender,address,credit,email) 
    VALUES ('$user[username]','$user[password]','$user[gender]','$user[address]','0','$user[email]')");
    if($result){
    	$response->write(json_encode(array('success'=>1)));
    }else{
		$response->write(json_encode(array('success'=>0)));
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 用户更新
 */
$app->post('/update', function ($request, $response,$args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $user = $request->getParsedBody();
    $result = mysqli_query($conn,"UPDATE user set password= '$user[password]',gender='$user[gender]',address='$user[address]',credit='$user[credit]',email='$user[email]'
    WHERE username='$user[username]'");
    if($result){
    	$response->write(json_encode(array('success'=>1)));
    }else{
		$response->write(json_encode(array('success'=>0)));
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 用户粉丝
 */
$app->get('/follower/{username}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $name = $request->getAttribute('username');
    $result = mysqli_query($conn,"SELECT followerName,avatar FROM user_follower,user 
	WHERE user_follower.username='{$name}' AND user.username=followerName");
    if(mysqli_num_rows($result)){
		$results = array();
		while ($row = mysqli_fetch_assoc($result)) {
			$results[] = $row;
		}
	    $response->write(json_encode($results)); 
  	 
    }else{
		$response->write("0");  
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 用户收藏
 */
$app->get('/collection/{username}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $name = $request->getAttribute('username');
    $result = mysqli_query($conn,"SELECT post_Id FROM user_collect
	WHERE username='{$name}'");
    if(mysqli_num_rows($result)){
		$results = array();
		while ($row = mysqli_fetch_assoc($result)) {
			$results[] = $row;
		}
	        $response->write(json_encode($results)); 
  	 
    }else{
		$response->write("0");  
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 用户发过的帖子
 */
$app->get('/history/{username}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $name = $request->getAttribute('username');
    $result = mysqli_query($conn,"SELECT * FROM post WHERE username='{$name}'");
    if(mysqli_num_rows($result)){
		$results = array();
		while ($row = mysqli_fetch_assoc($result)) {
			$results[] = $row;
		}
	        $response->write(json_encode($results)); 
  	 
    }else{
		$response->write("0");  
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 发帖子
 */
$app->post('/addPost', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $data = $request->getParsedBody();
    $result = mysqli_query($conn,"INSERT INTO post(username,content,title,state,star_num,collect_num,catelog)
	VALUES ('$data[username]','$data[content]','$data[title]','$data[state]',0,0,'$data[catelog]')");
    if($result){
    	$response->write(json_encode(array('success'=>1)));
    }else{
		$response->write(json_encode(array('success'=>0)));
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 删帖子
 */
$app->get('/deletePost/{id}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $id = $request->getAttribute('id');
    $result = mysqli_query($conn,"DELETE FROM post WHERE id='{$id}'");
    if($result){
    	$response->write(json_encode(array('success'=>1)));
    }else{
		$response->write(json_encode(array('success'=>0)));
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 编辑帖子
 */
$app->post('/updatePost', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $data = $request->getParsedBody();
    $result = mysqli_query($conn,"UPDATE post SET content='$data[content]',title='$data[title]',state='$data[state]',catelog='$data[catelog]'
	WHERE id='$data[id]'");
    if($result){
    	$response->write(json_encode(array('success'=>1)));
    }else{
		$response->write(json_encode(array('success'=>0)));
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 展示帖子
 */
$app->get('/showPost/{id}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $id = $request->getAttribute('id');
    $result = mysqli_query($conn,"SELECT * FROM post WHERE id='{$id}'");
    if(mysqli_num_rows($result)){
		$results = array();
		while ($row = mysqli_fetch_assoc($result)) {
			$results[] = $row;
		}
	    $response->write(json_encode($results[0])); 
  	 
    }else{
		$response->write("0");  
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 根据类别展示帖子列表
 */
$app->get('/showPostByCategory/{category}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $category = $request->getAttribute('category');
    $result = mysqli_query($conn,"SELECT * FROM post WHERE catelog='{$category}'");
    if(mysqli_num_rows($result)){
		$results = array();
		while ($row = mysqli_fetch_assoc($result)) {
			$results[] = $row;
		}
	    $response->write(json_encode($results)); 
  	 
    }else{
		$response->write("0");  
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 展示评论
 */
$app->get('/showComment/{id}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $id = $request->getAttribute('id');
    $result = mysqli_query($conn,"SELECT * FROM comment WHERE post_Id='{$id}'");
    if(mysqli_num_rows($result)){
		$results = array();
		while ($row = mysqli_fetch_assoc($result)) {
			$results[] = $row;
		}
	    $response->write(json_encode($results)); 
  	 
    }else{
		$response->write("0");  
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 添加评论
 */
$app->post('/addComment', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $data = $request->getParsedBody();
	echo $data[username];
    $result = mysqli_query($conn,"INSERT INTO comment(username,content,post_Id)
	VALUES ('$data[username]','$data[content]','$data[post_Id]')");
    if($result){
    	$response->write(json_encode(array('success'=>1)));
    }else{
		$response->write(json_encode(array('success'=>0)));
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 收藏帖子
 */
$app->post('/collectPost', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $data = $request->getParsedBody();
    $result = mysqli_query($conn,"INSERT INTO user_collect(username,post_Id)
	VALUES ('$data[username]','$data[post_Id]')");
    if($result){
    	$response->write(json_encode(array('success'=>1)));
    }else{
		$response->write(json_encode(array('success'=>0)));
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 点赞帖子
 */
$app->post('/starPost', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $data = $request->getParsedBody();
    $result = mysqli_query($conn,"INSERT INTO user_star(username,post_Id)
	VALUES ('$data[username]','$data[post_Id]')");
    if($result){
    	$response->write(json_encode(array('success'=>1)));
    }else{
		$response->write(json_encode(array('success'=>0)));
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 展示所有帖子
 */
$app->get('/showAllPosts', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
    $result = mysqli_query($conn,"SELECT * FROM post");
    if(mysqli_num_rows($result)){
		$results = array();
		while ($row = mysqli_fetch_assoc($result)) {
			$results[] = $row;
		}
	    $response->write(json_encode($results)); 
  	 
    }else{
		$response->write("0");  
    }
	mysqli_close($conn);
	return $response;  
});
/*
 * 获取图片
 */
$app->get('/getPostImage/{id}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
	$id = $request->getAttribute('id');
    $sth = mysqli_query($conn,"SELECT * FROM post_image where post_Id = '$id'");
    
    $result = mysqli_fetch_array($sth);
	mysqli_close($conn);
	$response->write($result['image']);
    return $response->withHeader('Content-Type', FILEINFO_MIME_TYPE);
	//echo '<img height="300" width="300" src="data:image/jpeg;base64,'.base64_encode( $result['image'] ).'"/>';
	
});
/*
 * 上传图片
 */
$app->post('/uploadImage/{id}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
	$id = $request->getAttribute('id');
    $image = addslashes(file_get_contents($_FILES['file']['tmp_name']));
    $image = base64_encode($image);
	$query = "INSERT INTO post_image (post_Id,image) VALUES('$id','$image')";  
    mysqli_query($conn, $query);
	mysqli_close($conn);
	return $response;  
});
/*
 * 得到用户收获的赞数
 */
$app->get('/stars/{username}', function ($request, $response, $args) {
	$conn = mysqli_connect("localhost", "tj", "123456","mySharing");
	if (!$conn) {
		die("Connection failed: " . mysqli_connect_error());
	}
	$username = $request->getAttribute('username');
    $result = mysqli_query($conn,"SELECT count(*) AS count FROM user_star WHERE username='{$username}' group by username");
	if(mysqli_num_rows($result)){
		$rs = mysqli_fetch_array($result);
		$response->write(json_encode(array('success'=>$rs[0])));
	}else{
		$response->write(json_encode(array('success'=>0)));
	}
	
  	mysqli_close($conn);
    return $response;  
	
});
$app->run();