package com.cos.action.comment;

import com.cos.action.Action;

public class CommentFactory {
	public static Action getAction(String cmd) {
		if(cmd.equals("delete")) {
			return new CommentDeleteAction();
		}else if(cmd.equals("write")) {
			return new CommentWriteAction();
		} else if(cmd.equals("show")) {
			return new CommentShowAction();
		}
		return null;
	}
}

