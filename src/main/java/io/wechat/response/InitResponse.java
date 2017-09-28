package io.wechat.response;

import lombok.Data;

import java.util.List;

@Data
public class InitResponse extends AbstractWechatResponse implements WechatResponse {
    private InitResponse.BaseResponse BaseResponse;
    private int Count;
    private InitResponse.SyncKey SyncKey;
    private InitResponse.User User;
    private String ChatSet;
    private String SKey;
    private int ClientVersion;
    private int SystemTime;
    private int GrayScale;
    private int InviteStartCount;
    private int MPSubscribeMsgCount;
    private int ClickReportInterval;
    private List<InitResponse.ContactList> ContactList;
    private List<InitResponse.MPSubscribeMsgList> MPSubscribeMsgList;


    @Data
    public static class BaseResponse {
        private int Ret;
        private String ErrMsg;
    }

    @Data
    public static class SyncKey {
        private int Count;
        private List<Pair> List;

        @Data
        public static class Pair {
            private int Key;
            private int Val;
        }
    }

    @Data
    public static class User {

        private int Uin;
        private String UserName;
        private String NickName;
        private String HeadImgUrl;
        private String RemarkName;
        private String PYInitial;
        private String PYQuanPin;
        private String RemarkPYInitial;
        private String RemarkPYQuanPin;
        private int HideInputBarFlag;
        private int StarFriend;
        private int Sex;
        private String Signature;
        private int AppAccountFlag;
        private int VerifyFlag;
        private int ContactFlag;
        private int WebWxPluginSwitch;
        private int HeadImgFlag;
        private int SnsFlag;

    }

    @Data
    public static class ContactList {
        private int Uin;
        private String UserName;
        private String NickName;
        private String HeadImgUrl;
        private int ContactFlag;
        private int MemberCount;
        private String RemarkName;
        private int HideInputBarFlag;
        private int Sex;
        private String Signature;
        private int VerifyFlag;
        private int OwnerUin;
        private String PYInitial;
        private String PYQuanPin;
        private String RemarkPYInitial;
        private String RemarkPYQuanPin;
        private int StarFriend;
        private int AppAccountFlag;
        private int Statues;
        private int AttrStatus;
        private String Province;
        private String City;
        private String Alias;
        private int SnsFlag;
        private int UniFriend;
        private String DisplayName;
        private int ChatRoomId;
        private String KeyWord;
        private String EncryChatRoomId;
        private int IsOwner;
        private List<?> MemberList;
    }

    @Data
    public static class MPSubscribeMsgList {
        private String UserName;
        private int MPArticleCount;
        private int Time;
        private String NickName;
        private List<MPArticleListBean> MPArticleList;


        @Data
        public static class MPArticleListBean {
            private String Title;
            private String Digest;
            private String Cover;
            private String Url;
        }
    }
}
