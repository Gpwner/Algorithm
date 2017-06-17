#include<iostream>
#include<math.h>
using namespace std;
int g_maxValue = 6;
void SumProbabilityOfDices(int number, int* pProbabilities);
void PrintSumProbabilityOfDices(int number);
void SumProbabilityOfDices(int original, int current, int value, int tempSum, int* pProbabilities);


void PrintSumProbabilityOfDices(int number)
{
    if(number < 1)
        return;
    int maxSum = number * g_maxValue;
    int* pProbabilities = new int[maxSum - number + 1];
    for(int i = number; i <= maxSum; ++i)
        pProbabilities[i - number] = 0;
    SumProbabilityOfDices(number, pProbabilities);
    int total = pow((float)g_maxValue, number);
    for(int i = number; i <= maxSum; ++i)
    {
        float ratio = (float)pProbabilities[i - number] / total;
        cout<<i<<"  "<<ratio<<endl;
    }
}
//niumber是骰子的个数，pProbabilities结果的存储数组
void SumProbabilityOfDices(int number, int* pProbabilities)
{
    for(int i = 1; i <= g_maxValue; ++i)
        SumProbabilityOfDices(number, number, i, 0, pProbabilities);
}

void SumProbabilityOfDices(int original, int current, int value, int tempSum, int* pProbabilities)
{
    if(current == 1)
    {
        int sum = value + tempSum;
        pProbabilities[sum - original]++;
    }
    else
    {
        for(int i = 1; i <= g_maxValue; ++i)
        {
            int sum = value + tempSum;
            SumProbabilityOfDices(original, current - 1, i, sum, pProbabilities);
        }
    }
}

int main()
{
    PrintSumProbabilityOfDices(6);
}
