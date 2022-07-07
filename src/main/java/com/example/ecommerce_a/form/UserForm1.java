package com.example.ecommerce_a.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.ecommerce_a.domain.model.ValidGroup1;
import com.example.ecommerce_a.domain.model.ValidGroup2;

/**
 * ユーザー登録時に使用するフォーム
 * 
 * @author mikami
 *
 */
public class UserForm1 {
	@NotBlank(message = "ユーザー名を入力してください", groups = ValidGroup1.class)
	@Size(max = 10, min = 1, message = "10文字以下で設定ください", groups = ValidGroup2.class)
	private String userName;
	
	@NotBlank(message = "メールアドレスを入力してください", groups = ValidGroup1.class)
	@Email(message="メールアドレスの形式が不正です", groups = ValidGroup2.class)
	private String email;

	// 半角小文字英字、全角大文字英字、半角数字、記号（.-_）の4種類のうち、3種類を含むよう設定
	@NotBlank(message = "パスワードを入力してください", groups = ValidGroup1.class)
	@Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])|(?=.*[a-z])(?=.*[A-Z])(?=.*[\\.-_])|(?=.*[A-Z])(?=.*[0-9])(?=.*[\\.-_])|(?=.*[a-z])(?=.*[0-9])(?=.*[\\.-_]))([a-zA-Z0-9\\.-_]){8,24}$", message = "パスワードの形式が不正です", groups = ValidGroup2.class)
	private String password;

	// コンストラクタで半角・全角スペースを削除する
	public UserForm1(String userName, String email, String password) {
		super();
		this.userName = userName.strip().replaceAll("　| ", "");
		this.email = email.strip().replaceAll("　| ", "");
		this.password = password.strip().replaceAll("　| ", "");
	}

	public UserForm1() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
