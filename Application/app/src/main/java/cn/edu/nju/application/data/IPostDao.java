package cn.edu.nju.application.data;

import java.util.List;

import cn.edu.nju.application.presentation.model.Comment;
import cn.edu.nju.application.presentation.model.Post;
import cn.edu.nju.application.presentation.model.UserCollect;
import cn.edu.nju.application.presentation.model.UserStar;

/**
 * Created by phoebegl on 16/9/21.
 */
public interface IPostDao {

    /**
     * 发表新帖子
     * @param post
     * @return
     */
    int addPost(Post post);

    /**
     * 删除原有帖子
     * @param id
     * @return
     */
    int deletePost(int id);

    /**
     * 编辑原贴
     * @param post
     * @return
     */
    int updatePost(Post post);

    /**
     * 显示帖子具体信息
     * @param id
     * @return
     */
    Post showPost(int id);

    /**
     * 根据类别显示帖子
     * @param catelog
     * @return
     */
    List<Post> showPostList(String catelog);

    /**
     * 显示帖子评论
     * @param id
     * @return
     */
    List<Comment> showComments(int id);

    /**
     * 发表评论
     * @param comment
     * @return
     */
    int addComment(Comment comment);

    /**
     * 收藏帖子
     * @param collect
     * @return
     */
    int collectPost(UserCollect collect);

    /**
     * 给帖子点赞
     * @param star
     * @return
     */
    int starPost(UserStar star);
}
