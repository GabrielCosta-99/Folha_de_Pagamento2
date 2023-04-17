import java.util.Scanner;
 

class Main {
  public static void main(String[] args) {

 Scanner ler = new Scanner(System.in); 
  // variaveis 

  String nome, setor, cargo, mesReferen; 
  double salarioBruto, pensaoAlim, salarioHora, va, descontoFgts, benePericulosidade, vt, dependentesIR, aliquotaEfetiva, incidenciaMensal, beneInsalubridade,totalDeducoes,baseCalculo, vaTotal = 0.0; 
  int diasTrabalhadosSem, horasDiarias,horasSemanais, periculosidade, insalubridade,vtTrue, diasUteisTrab= 0;
  String dataAdm,mesNum; 
  int dependentes, jornadaSemanal, jornadaMensal = 0;
  double primeiraFase, segundaFase, terceiraFase, quartaFase, quintaFase, salarioLiq = 0.0; 
  double inss = 0.0;
  double irrf = 0.0;
     
    
    // Dados do colaborador
    
  System.out.println("Digite os dados do colaborador");
  System.out.print("Nome: ");
  nome = ler.nextLine();
  System.out.print("Cargo: ");
  cargo = ler.nextLine();
  System.out.print("Data de admissão: ");
  dataAdm = ler.nextLine();
  System.out.print("Mês Referência: ");
  mesReferen = ler.nextLine();
  System.out.print("Salário bruto: ");
  salarioBruto = ler.nextDouble();
  System.out.print("Horas diarias: ");
  horasDiarias = ler.nextInt(); 
  System.out.print("Dias trabalhados na semana: ");
  diasTrabalhadosSem = ler.nextInt();
  System.out.print("Valor diario do V.A: ");
  va = ler.nextDouble();
  System.out.print("O colaborador paga pensao alimenticia? se sim, digite o valor, se nao, digite 0: ");
pensaoAlim = ler.nextDouble();
System.out.print("O colaborador possui insalubridade? Digite 1 para baixo, 2 para media e 3 para alto risco: ");
insalubridade = ler.nextInt();
System.out.print("O colaborador possui periculosidade? se sim digite 1, se não, digite 0: ");
periculosidade = ler.nextInt();
System.out.print("Quantos dias uteis trabalhados: ");
diasUteisTrab = ler.nextInt();
System.out.print("O colaborador faz uso de Vale transporte? Se sim, digite 1, se não, digite 0 ");
vtTrue = ler.nextInt();
System.out.print("Possui dependentes: ");
dependentes = ler.nextInt();
    

               // Calculo Jornada de Trabalho semanal  

   jornadaSemanal = horasDiarias * diasTrabalhadosSem; 

                // Horas por semana 

    horasSemanais = horasDiarias * diasTrabalhadosSem;
    
               // Calculo jornada de trabalho mensal 

    jornadaMensal = horasSemanais * 4;

               // Calculo salario hora

    salarioHora = salarioBruto / jornadaMensal; 

               // Calculo FGTS 
    
    descontoFgts = salarioBruto * 0.08;
    
              // calculo insalubridade

    switch (insalubridade){
      case 1:
       beneInsalubridade = salarioBruto * 0.1;
        break;
      case 2:
       beneInsalubridade = salarioBruto * 0.2;
        break;
      case 3:
       beneInsalubridade = salarioBruto * 0.4; 
        break;
      default:
        System.out.print("Não se faz necessário a periculosidade"); }

                    // calculo periculosidade 

     if (periculosidade == 1){

       benePericulosidade = salarioBruto * 0.3; 
     } else {

       benePericulosidade = salarioBruto + 0; 
    }

                    // Calculo Vale Alimentação 

       vaTotal = diasUteisTrab * va;


                   // calculo vale transporte 

        if (vtTrue == 1){

          vt = salarioBruto * 0.06;
        } else{
          vt = salarioBruto + 0;
        }
    

                  // Calculo INSS
  
if (salarioBruto <= 1302.00){

  inss = salarioBruto * 0.075;
}
else if  (salarioBruto <= 2571.29){

  primeiraFase = 1302.00 * 0.075;
  segundaFase = (2571.29 - 1302.00) * 0.09; 
  terceiraFase = (salarioBruto-2571.29) * 0.12; 
  inss = primeiraFase + segundaFase + terceiraFase; }

else if (salarioBruto <= 3856.94){

  primeiraFase = 1302.00 * 0.075;
  segundaFase = (2571.29 - 1302.00) * 0.09; 
  terceiraFase = (3856.94 - 2571.29) * 0.12; 
  quartaFase = (salarioBruto - 3856.94) * 0.14; 

  inss = primeiraFase + segundaFase + terceiraFase + quartaFase;}

else if (salarioBruto >= 7507.49){

  primeiraFase = 1302.00 * 0.075;
  segundaFase = (2571.29 - 1302.00) * 0.09; 
  terceiraFase = (3856.94 - 2571.29) * 0.12; 
  quartaFase = (7507.49 - 3856.94) * 0.14; 
  quintaFase = (salarioBruto- 7507.49)* 0.14; 
  inss = primeiraFase + segundaFase + terceiraFase + quartaFase + quintaFase; }

                       // calculo IRRF

if (salarioBruto < 1903.98) {
  System.out.print("Isento do imposto de renda");
} 
if (salarioBruto <= 2826.65){
 dependentesIR = dependentes * 189.59;
 totalDeducoes = pensaoAlim + inss + dependentesIR;
  baseCalculo = salarioBruto - totalDeducoes;
incidenciaMensal = baseCalculo * 0.075;
    irrf = incidenciaMensal - 142.80;
    aliquotaEfetiva = irrf / salarioBruto;
} 
if (salarioBruto <= 3751.05) {
    dependentesIR = dependentes * 189.59;
    totalDeducoes = pensaoAlim + inss + dependentesIR;
    baseCalculo = salarioBruto - totalDeducoes;
    incidenciaMensal = baseCalculo * 0.15;
    irrf = incidenciaMensal - 354.80;
    aliquotaEfetiva = irrf / salarioBruto;
} 
if (salarioBruto <= 4664.68) {
    dependentesIR = dependentes * 189.59;
    totalDeducoes = pensaoAlim + inss + dependentesIR;
    baseCalculo = salarioBruto - totalDeducoes;
    incidenciaMensal = baseCalculo * 0.225;
    irrf = incidenciaMensal - 636.13;
    aliquotaEfetiva = irrf / salarioBruto;
}
  if(salarioBruto > 4664.68){
    dependentesIR = dependentes * 189.59;
    totalDeducoes = pensaoAlim + inss + dependentesIR;
    baseCalculo = salarioBruto - totalDeducoes;
    incidenciaMensal = baseCalculo * 0.275;
    irrf = incidenciaMensal - 869.36;
    aliquotaEfetiva = irrf / salarioBruto;
}
                  // Calculo salario liquido

  salarioLiq = salarioBruto - inss - descontoFgts  - vt - irrf;
  salarioLiq = salarioLiq + periculosidade + insalubridade; 

                 // Holerite de Pagamento

System.out.println("Mês de Referência: " + mesReferen);

System.out.println("Nome do Colaborador: "+ nome);
System.out.print("Data de Admissão: "+ dataAdm );
System.out.print("Cargo: "+ cargo);

System.out.println("Salário Bruto: "+ salarioBruto);
System.out.println("Vale Transporte: "+ vt);
System.out.println("Vale Alimentação: " + va);
System.out.println("INSS: "+ inss);
System.out.println("FGTS: " + descontoFgts);
System.out.println("Imposto de Renda: " + irrf);
System.out.println("Periculosidade/Insalubridade: " + periculosidade + insalubridade);

System.out.println("Salário Líquido: " + salarioLiq );

System.out.println("Horas Diárias: "+ horasDiarias +" horas");
System.out.println("Dias Trabalhados: "+ diasTrabalhadosSem+ " dias");


System.out.println("Jornada Mensal:"+ jornadaMensal+ " horas");
System.out.println("jornada Semanal: " + jornadaSemanal+ " horas" );

System.out.println("Cálculo de Salário Hora: "+
"Salario Bruto" + salarioBruto +"/"+ "Jornada Mensal" + jornadaMensal + "=" + salarioHora);

    




  }
}
