from random import randint

def main():
	qntProcessos = int(input("Insira a quantidade de processos para gerar o arquivo CSV: "))
	zero = len(str(qntProcessos))
	processos = []
	
	for i in range(qntProcessos):
		if(len(str(i + 1)) < zero):
			processos.append("P" + str(inserirZero(zero, i + 1)) + "" + str(i + 1) + "," + str(randint(50, 200)) + "," + str(randint(0, qntProcessos + 3)) + "," + str(randint(20, 50)))
		else:
			processos.append("P" + str(i + 1) + "," + str(randint(50, 200)) + "," + str(randint(0, qntProcessos + 3)) + "," + str(randint(20, 50)))


	gerarcsv(processos, qntProcessos)
	print("Arquivo CSV gerado com sucesso!")

def gerarcsv(lista, qntProcessos):
	arquivo = open("Processos " + str(qntProcessos) + ".csv", 'w')
	for i in range(len(lista)):
		arquivo.writelines(str(lista[i]) + "\n")
	arquivo.close

def inserirZero(zero, i):
	add = ""
	tamanhoNum = len(str(i))
	for i in range(0, (zero - tamanhoNum)):
		add += str(0)
	return str(add)

main()	