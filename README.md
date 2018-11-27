# dintsist-upload-client
# Aplicação do tipo Spring MVC

- Aplicação que permite o usuário fazer o upload de um arquivo de sinal para enviar para o servidor processar uma imagem.
- A princípio o arquivo deverá ser no formato .csv, pois a leitura do arquivo se baseia já em cada sinal separado por uma quebra de linha.
- Além disso, a aplicação disponível no repositório **dintsist-process-server** deverá ser iniciada antes para que ela disponibilize a
interface de processamento que será acessada via remote method invocation (RMI), caso essa aplicação não seja iniciada antes, essa aplicação não conseguirá
achar a interface que necessita para envio dos dados e por isso gerará exceção.
- Utiliza o **maven** para gerenciar as dependências.
