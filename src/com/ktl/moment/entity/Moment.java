package com.ktl.moment.entity;

public class Moment{
	private long momentId;//灵感id
	private String title;//标题
	private String content;//内容
	private String momentImg;//灵感内部的图片
	private String postTime;//发布时间
	private int followNums;//关注的用户个数
	private int praiseNums;//点赞的用户个数
	private int commentsNum;//评论数
	private long authorId;//发表人的id
	private String authorNickName;//作者昵称
	private String avatarUrl;//头像路径
	
	private int isPublic;//是否公开	0：不公开，1：公开
	private int isCollect;//是否收藏		0：不是收藏，1：收藏
	private String label;//灵感标签
	
	public int getIsPublic() {
		return isPublic;
	}
	public void setPublic(int isPublic) {
		this.isPublic = isPublic;
	}
	public int getIsCollect() {
		return isCollect;
	}
	public void setCollect(int isCollect) {
		this.isCollect = isCollect;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getMomentImg() {
		return momentImg;
	}
	public void setMomentImg(String momentImg) {
		this.momentImg = momentImg;
	}
	public int getCommentsNum() {
		return commentsNum;
	}
	public void setCommentsNum(int commentsNum) {
		this.commentsNum = commentsNum;
	}
	
	public long getMomentId() {
		return momentId;
	}
	public void setMomentId(long momentId) {
		this.momentId = momentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public int getFollowNums() {
		return followNums;
	}
	public void setFollowNums(int followNums) {
		this.followNums = followNums;
	}
	public int getPraiseNums() {
		return praiseNums;
	}
	public void setPraiseNums(int praiseNums) {
		this.praiseNums = praiseNums;
	}
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	public String getAuthorNickName() {
		return authorNickName;
	}
	public void setAuthorNickName(String authorNickName) {
		this.authorNickName = authorNickName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	
}
