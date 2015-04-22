package com.ktl.moment.entity;

public class Moment extends BaseEntity{
	private long momentId;//灵感id
	private String title;//标题
	private String content;//内容
	private String momentImg;//灵感内部的图片
	private String label;//灵感标签
	private String postTime;//发布时间
	private int collectNum;//关注的用户个数
	private int praiseNum;//点赞的用户个数
	private int commentNum;//评论数
	private long authorId;//发表人的id
	private String authorName;//作者昵称
	private String userAvatar;//头像路径
	private String audioUrl;//音频文件存储路径
	
	private int isPublic;//是否公开	0：不公开，1：公开
	private int isCollect;//是否收藏		0：不是收藏，1：收藏
	private int isFocused;//作者是否被关注	0:未被关注，1：关注
	
	public int getIsFocused() {
		return isFocused;
	}
	public void setIsFocused(int isFocused) {
		this.isFocused = isFocused;
	}
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
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
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
	public int getPraiseNum() {
		return praiseNum;
	}
	public void setPraiseNum(int praiseNum) {
		this.praiseNum = praiseNum;
	}
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	public int getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(int collectNum) {
		this.collectNum = collectNum;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	
	
}
