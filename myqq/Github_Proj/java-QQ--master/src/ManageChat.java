/**
 * ����һ�������û�����������
 */

import java.util.*;

public class ManageChat {

	private static HashMap hm=new HashMap<String, dialog_panel>();
	
	//����
	public static void addQqChat(String loginIdAnFriendId,dialog_panel dialog)
	{
		hm.put(loginIdAnFriendId, dialog);
	}
	//ȡ��
	public static dialog_panel getQqChat(String loginIdAnFriendId )
	{
		return (dialog_panel)hm.get(loginIdAnFriendId);
	}
	
}
