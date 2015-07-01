package week12.reflect;


interface Player {
    void play(String video);
}

//��������ʾ��̬����һ���࣬������ʵ��
class PlayerMaster {
    public static void main(String[] args) throws ClassNotFoundException, 
                            InstantiationException, IllegalAccessException {

        //String playerImpl = System.getProperty("PlayerImpl");
		//�������Դ�����������������һ��Ŀ¼�²������е��ļ���Ϊ�˱�������������д�̶��ˡ�
		String playerImpl = "SimplePlayer";

        Player player = (Player) Class.forName(playerImpl).newInstance();

		String movie = "����";

        player.play(movie);
    }
}

class SimplePlayer implements Player {
    @Override
    public void play(String video) {
        System.out.println("���ڲ��� " + video);
    }
    
}
