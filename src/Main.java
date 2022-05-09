import java.nio.charset.StandardCharsets;

public class Main {

    public static String transferCharTo16(String s) {
        if (s == null || s.trim().length() <= 0) {
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        System.out.println("size: " + bytes.length);
        for(byte b : bytes) {
            buffer.append("\\\\x");
            String change = Integer.toHexString(b & 0xFF);
            if (change.length() == 1) {
                buffer.append("0");
            }
            buffer.append(change.toUpperCase());
        }
        return buffer.toString();
    }

    public static String transfer16ToChar(byte[] bytes) throws Exception {
        return new String(bytes, "UTF-8");
    }

    public static void main(String[] args) throws Exception {

        //Sample to transfer 16 to Charsets
        byte[] bytes = new byte[]{(byte) 0xE5, (byte) 0x9B, (byte) 0xBD, (byte) 0xE8, (byte) 0x8D, (byte) 0xAF, (byte) 0xE5, (byte) 0x99, (byte) 0xA8, (byte) 0xE6, (byte) 0xA2, (byte) 0xB0, (byte) 0xE8, (byte) 0x81, (byte) 0x94, (byte) 0xE9, (byte) 0xBD, (byte) 0x90, (byte) 0xEF, (byte) 0xBC, (byte) 0x88, (byte) 0xE5, (byte) 0x8C, (byte) 0x97, (byte) 0xE4, (byte) 0xBA, (byte) 0xAC, (byte) 0xEF, (byte) 0xBC, (byte) 0x89, (byte) 0xE5, (byte) 0x8C, (byte) 0xBB, (byte) 0xE7, (byte) 0x96, (byte) 0x97, (byte) 0xE5, (byte) 0x99, (byte) 0xA8, (byte) 0xE6, (byte) 0xA2, (byte) 0xB0, (byte) 0xE6, (byte) 0x9C, (byte) 0x89, (byte) 0xE9, (byte) 0x99, (byte) 0x90, (byte) 0xE5, (byte) 0x85, (byte) 0xAC, (byte) 0xE5, (byte) 0x8F, (byte) 0xB8, (byte) 0xE4, (byte) 0xB8, (byte) 0xBB, (byte) 0xE4, (byte) 0xBB, (byte) 0x93, (byte) 0xE5, (byte) 0xBA, (byte) 0x93};

        try {
            System.out.println(transfer16ToChar(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //sample to transfer Charsets to 16
        System.out.println(transferCharTo16("国药器械联齐（北京）医疗器械有限公司主仓库"));
    }
}
